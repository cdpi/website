package io.github.cdpi.website.generator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.apache.commons.lang3.event.EventListenerSupport;
import org.apache.commons.lang3.function.FailableConsumer;
import io.github.cdpi.Argument;
import io.github.cdpi.annotations.WorkInProgress;
import io.github.cdpi.exceptions.NullArgumentException;
import io.github.cdpi.website.generator.events.WebSiteGeneratorEvent;

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
	public final void addEventListener(final IEventListener listener)
		{
		listeners.addListener(Argument.notNull(listener));
		}

	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.3.4
	 */
	public final void addEventListener(final IEventListener listener, final boolean allowDuplicate)
		{
		listeners.addListener(Argument.notNull(listener), allowDuplicate);
		}

	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.3.4
	 */
	public final void removeEventListener(final IEventListener listener)
		{
		listeners.removeListener(Argument.notNull(listener));
		}

	@Override
	@WorkInProgress
	public void run()
		{
		//ActionEvent e = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, "something");
		//final var event = new WebSiteGeneratorEvent(this);
		listeners.fire().run(new WebSiteGeneratorEvent(this));
		}

	//public static final IWebSitePublisher getWebSitePublisher(final String className) throws ReflectiveOperationException
	//return IWebSitePublisher.class.cast(Core.newInstance(className));

	//final var html = new MarkdownToHTML().process(source);
	//final var renderer = new HTML("templates").getTemplateRenderer(template);
	//final var webpage = renderer.render(Map.of("html", html));
	//Files.writeString(destination, webpage);

	@WorkInProgress
	public final void walk(final Path directory, final FailableConsumer<Path, IOException> consumer) throws IOException
		{
		Argument.notNull(directory);
		Argument.notNull(consumer);

		try (final var paths = Files.newDirectoryStream(directory))
			{
			listeners.fire().walk(new WebSiteGeneratorEvent(this));

			for (final var path : paths)
				{
				consumer.accept(path);
				}
			}
		}

	/*
	public final void devMarkdownToHTML(final Path directory) throws IOException
		{
		final var paths = new ArrayList<Path>();

		devWalk(directory, path ->
			{
			final var isMarkdown = path.getFileName().toString().endsWith(".md");

			if (isMarkdown)
				{
				paths.add(path);
				}
			});

		final var markdown = new Markdown();

		markdown.toHTML(paths, (path, html) ->
			{
			System.out.println(path);
			System.out.println(html);
			System.out.println();
			System.out.println("-----------------------------------------------------------------");
			System.out.println();
			});
		}
	*/
	}
