package io.github.cdpi.website.generator;

public final class Main
	{
	private Main()
		{
		throw new UnsupportedOperationException();
		}

	public static void main(final String[] args)
		{
		try
			{
			new WebSiteGenerator().run();
			}
		catch (final Throwable ex)
			{
			ex.printStackTrace();
			}
		}
	}
