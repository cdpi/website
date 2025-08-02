package io.github.cdpi.website.generator.exceptions;

/**
 * <h1>WebSiteGeneratorException</h1>
 * 
 * @version 0.3.2
 * @since 0.3.2
 */
public class WebSiteGeneratorException extends RuntimeException
	{
	/**
	 * @since 0.3.2
	 */
	public WebSiteGeneratorException()
		{
		super();
		}

	/**
	 * @since 0.3.2
	 */
	public WebSiteGeneratorException(final String message)
		{
		super(message);
		}

	/**
	 * @since 0.3.2
	 */
	public WebSiteGeneratorException(final Throwable cause)
		{
		super(cause);
		}
	}
