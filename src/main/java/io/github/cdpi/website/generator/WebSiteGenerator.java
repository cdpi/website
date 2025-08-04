package io.github.cdpi.website.generator;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Consumer;
import org.apache.commons.lang3.event.EventListenerSupport;
import io.github.cdpi.Argument;
import io.github.cdpi.annotations.WorkInProgress;
import io.github.cdpi.exceptions.NullArgumentException;

/**
 * <h1>WebSiteGenerator</h1>
 * 
 * @version 0.3.4
 * @since 0.3.2
 */
public final class WebSiteGenerator extends Configuration implements IWebSiteGenerator
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

		final var configuration = getConfiguration("website.json");

		//System.out.println(configuration.get("source"));
		//System.out.println(configuration.get("destination"));

		//final var markdown = new Markdown();

		walk(Paths.get(configuration.get("source").toString()), path ->
			{
			System.out.println(path);
			/*
			if (io.github.cdpi.IO.isMarkdown().test(path))
				{
				final var html = markdown.render(path);
				System.out.println(html);
				}
			*/
			});
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
