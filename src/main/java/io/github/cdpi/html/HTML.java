package io.github.cdpi.html;

import java.io.IOException;
import java.nio.file.Paths;
import io.github.cdpi.Argument;
import io.github.cdpi.exceptions.NullArgumentException;
import io.github.cdpi.freemarker.FreeMarker;
import io.github.cdpi.freemarker.TemplateRenderer;

/**
 * <h1>HTML</h1>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public class HTML
	{
	protected final FreeMarker engine;

	/**
	 * @throws NullArgumentException
	 * @throws IOException
	 * 
	 * @since 0.1.0
	 */
	public HTML(final String templatesDirectory) throws IOException
		{
		super();

		final var path = Paths.get(Argument.notNull(templatesDirectory));

		engine = new FreeMarker.Builder().setTemplatesDirectory(path).build();
		}

	/**
	 * @throws IOException 
	 * 
	 * @since 0.1.0
	 */
	public final TemplateRenderer getTemplateRenderer(final String template) throws IOException
		{
		return engine.getTemplateRenderer(template);
		}
	}
