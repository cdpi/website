package io.github.cdpi.freemarker;

import java.io.IOException;
import java.io.StringWriter;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import io.github.cdpi.Argument;
import io.github.cdpi.exceptions.NullArgumentException;

/**
 * <h1>TemplateRenderer</h1>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public final class TemplateRenderer
	{
	private final Template template;

	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.1.0
	 */
	TemplateRenderer(final Template template)
		{
		super();

		this.template = Argument.notNull(template);
		}

	/**
	 * @throws IOException
	 * @throws TemplateException
	 * 
	 * @since 0.1.0
	 */
	public String render(final Object model) throws IOException, TemplateException
		{
		try (final var writer = new StringWriter())
			{
			template.process(model, writer);

			return writer.toString();
			}
		}
	}
