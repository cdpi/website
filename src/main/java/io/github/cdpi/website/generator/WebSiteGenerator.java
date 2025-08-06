package io.github.cdpi.website.generator;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;
import java.util.function.Function;
import org.apache.commons.lang3.event.EventListenerSupport;
import io.github.cdpi.Argument;
import io.github.cdpi.io.IO;
import io.github.cdpi.annotations.WorkInProgress;
import io.github.cdpi.exceptions.NullArgumentException;
import io.github.cdpi.website.generator.configuration.Configuration;

/**
 * <h1>WebSiteGenerator</h1>
 * 
 * @version 0.3.4
 * @since 0.3.2
 */
public final class WebSiteGenerator implements IWebSiteGenerator
	{
	private final EventListenerSupport<IEventListener> listeners = EventListenerSupport.create(IEventListener.class);

	/**
	 * @since 0.3.2
	 */
	public WebSiteGenerator()
		{
		super();
		}

	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.3.2
	 */
	@Override
	public final void addEventListener(final IEventListener listener)
		{
		listeners.addListener(Argument.notNull(listener));
		}

	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.3.4
	 */
	@Override
	public final void addEventListener(final IEventListener listener, final boolean allowDuplicate)
		{
		listeners.addListener(Argument.notNull(listener), allowDuplicate);
		}

	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.3.4
	 */
	@Override
	public final void removeEventListener(final IEventListener listener)
		{
		listeners.removeListener(Argument.notNull(listener));
		}

	@Override
	@WorkInProgress
	public void run() throws IOException
		{
		//ActionEvent e = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "something");
		//final var event = new WebSiteGeneratorEvent(this);
		//listeners.fire().run(new WebSiteGeneratorEvent(this));

		final var configuration = Configuration.parse(Paths.get("website.json"));

		/*
		System.out.println(configuration.getName());
		System.out.println(configuration.getURL());
		System.out.println(configuration.getDestination());

		configuration.getSources().forEach(source ->
			{
			System.out.println(source.getPath());
			});
		*/

		//https://stackoverflow.com/a/924519
		//fileNameWithOutExt = "test.xml".replaceFirst("[.][^.]+$", "");
		final Function<Path, String> filename = path -> path.getFileName().toString().replaceFirst("[.][^.]+$", "");

		final var markdown = new Markdown();

		configuration.getSources().forEach(source ->
			{
			walk(source.getPath(), path ->
				{
				//System.out.println(path);
				final var temp = configuration.getDestination().resolve(source.getPath().relativize(path));
				//System.out.println(temp);
				final var file = filename.apply(temp.getFileName()) + ".html";
				final var sdsds = temp.resolveSibling(file);
				//System.out.println(sdsds);

				final var html = markdown.render(path);

				IO.WRITE.apply(sdsds, html);
				});
			});
		/*
		walk(source, path ->
			{
			//System.out.println(source.relativize(path));
			//var x = destination.resolve(source.relativize(path));
			//System.out.println(x);

			final var temp = destination.resolve(source.relativize(path)).toString() + ".html";

			final var html = markdown.render(path);

			IO.WRITE.apply(Paths.get(temp), html);
			});
		*/
		}

	@WorkInProgress
	public final void walk(final Path directory, final Consumer<Path> consumer)
		{
		Argument.notNull(directory);
		Argument.notNull(consumer);

		try (final var paths = Files.newDirectoryStream(directory))
			{
			//listeners.fire().walk(new WebSiteGeneratorEvent(this));

			for (final var path : paths)
				{
				consumer.accept(path);
				}
			}
		catch (final IOException ex)
			{
			throw new UncheckedIOException(ex);
			}
		}
	}
