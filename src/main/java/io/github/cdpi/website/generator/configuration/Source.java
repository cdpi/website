package io.github.cdpi.website.generator.configuration;

import java.nio.file.Path;

/**
 * <h1>Source</h1>
 * 
 * @version 0.3.5
 * @since 0.3.5
 */
public final class Source
	{
	private String path;

	/**
	 * @since 0.3.5
	 */
	private Source()
		{
		super();
		}

	/**
	 * @since 0.3.5
	 */
	public Path getPath()
		{
		return Path.of(path);
		}

	//Directory

	//public static final IWebSitePublisher getWebSitePublisher(final String className) throws ReflectiveOperationException
	//return IWebSitePublisher.class.cast(Core.newInstance(className));

	//final var html = new MarkdownToHTML().process(source);
	//final var renderer = new HTML("templates").getTemplateRenderer(template);
	//final var webpage = renderer.render(Map.of("html", html));
	//Files.writeString(destination, webpage);
	}
