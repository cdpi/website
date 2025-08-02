package io.github.cdpi.freemarker;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import io.github.cdpi.Argument;
import io.github.cdpi.exceptions.NullArgumentException;

/**
 * <h1>FreeMarker</h1>
 * 
 * @version 0.1.0
 * @since 0.1.0
 */
public class FreeMarker
	{
	private final Configuration configuration;

	/**
	 * @throws NullArgumentException
	 * 
	 * @since 0.1.0
	 */
	protected FreeMarker(final Configuration configuration)
		{
		super();

		this.configuration = Argument.notNull(configuration);
		}

	/**
	 * @throws IOException
	 * 
	 * @since 0.1.0
	 */
	public final TemplateRenderer getTemplateRenderer(final String template) throws IOException
		{
		return new TemplateRenderer(configuration.getTemplate(template));
		}

	/**
	 * <h1>FreeMarker.Builder</h1>
	 * 
	 * @version 0.1.0
	 * @since 0.1.0
	 */
	public static final class Builder
		{
		private Charset encoding;
		private Version version;
		private Path templatesDirectory;

		/**
		 * @since 0.1.0
		 */
		public Builder()
			{
			this.encoding = StandardCharsets.UTF_8;
			this.version = Configuration.VERSION_2_3_34;
			this.templatesDirectory = null; // Default to null, must be set later
			}

		/**
		 * @throws NullArgumentException
		 * 
		 * @since 0.1.0
		 */
		public Builder setEncoding(final Charset encoding)
			{
			this.encoding = Argument.notNull(encoding);

			return this;
			}

		/**
		 * @throws NullArgumentException
		 * 
		 * @since 0.1.0
		 */
		public Builder setTemplatesDirectory(final Path templatesDirectory)
			{
			this.templatesDirectory = Argument.notNull(templatesDirectory);

			return this;
			}

		/**
		 * @throws NullArgumentException
		 * 
		 * @since 0.1.0
		 */
		public Builder setVersion(final Version version)
			{
			this.version = Argument.notNull(version);

			return this;
			}

		/**
		 * @throws IOException
		 * 
		 * @since 0.1.0
		 */
		public FreeMarker build() throws IOException
			{
			// TODO: Error handling
			// enc
			//if (templatesDirectory == null)
			//	throw new IllegalStateException("Templates directory must be set");
			// version

			final var configuration = new Configuration(version);

			configuration.setDirectoryForTemplateLoading(templatesDirectory.toFile());

			configuration.setDefaultEncoding(encoding.name());

			configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

			configuration.setLogTemplateExceptions(false);

			configuration.setWrapUncheckedExceptions(true);

			configuration.setFallbackOnNullLoopVariable(false);

			//cfg.setSQLDateAndTimeTimeZone(TimeZone.getDefault());

			return new FreeMarker(configuration);
			}
		}
	}
