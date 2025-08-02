package io.github.cdpi.website.generator;

import io.github.cdpi.website.generator.events.WebSiteGeneratorEvent;

/**
 * <h1>IWebSiteGenerator</h1>
 * 
 * @version 0.3.4
 * @since 0.3.2
 */
@FunctionalInterface
public interface IWebSiteGenerator extends Runnable
	{
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
