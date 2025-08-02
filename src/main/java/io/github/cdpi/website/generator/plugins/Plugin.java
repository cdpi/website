package io.github.cdpi.website.generator.plugins;

import java.io.IOException;
import java.nio.file.Path;
import org.apache.commons.lang3.NotImplementedException;

/**
 * <h1>Plugin</h1>
 * 
 * @version 0.3.0
 * @since 0.1.0
 */
public class Plugin implements IPlugin
	{
	/**
	 * @since 0.1.0
	 */
	public Plugin()
		{
		super();
		}

	/**
	 * @throws IOException
	 * @throws ReflectiveOperationException
	 * 
	 * @since 0.3.0
	 */
	public static final IPlugin loadPlugin(final Path path, final String name) throws IOException, ReflectiveOperationException
		{
		//return IPlugin.class.cast(load(path, name));
		throw new NotImplementedException();
		}
	}
