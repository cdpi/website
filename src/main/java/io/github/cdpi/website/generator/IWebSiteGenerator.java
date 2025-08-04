package io.github.cdpi.website.generator;

import java.io.IOException;
import org.apache.commons.lang3.function.FailableRunnable;
import io.github.cdpi.website.generator.events.WebSiteGeneratorEvent;

/**
 * <h1>IWebSiteGenerator</h1>
 * 
 * @version 0.3.4
 * @since 0.3.2
 */
public interface IWebSiteGenerator extends FailableRunnable<IOException>
	{
	/**
	 * @since 0.3.4
	 */
	public void addEventListener(IEventListener listener);

	/**
	 * @since 0.3.4
	 */
	public void addEventListener(IEventListener listener, boolean allowDuplicate);

	/**
	 * @since 0.3.4
	 */
	public void removeEventListener(IEventListener listener);

	/**
	 * <h1>IWebSiteGenerator.IEventListener</h1>
	 * 
	 * @version 0.3.4
	 * @since 0.3.2
	 */
	public static interface IEventListener
		{
		/**
		 * @since 0.3.4
		 */
		public void run(WebSiteGeneratorEvent event);

		/**
		 * @since 0.3.4
		 */
		public void walk(WebSiteGeneratorEvent event);
		}
	}
