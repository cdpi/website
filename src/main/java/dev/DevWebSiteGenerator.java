package dev;

import java.nio.file.Paths;
import io.github.cdpi.website.generator.IWebSiteGenerator;
import io.github.cdpi.website.generator.WebSiteGenerator;
import io.github.cdpi.website.generator.events.WebSiteGeneratorEvent;

public final class DevWebSiteGenerator
	{
	public static void main(String[] args)
		{
		try
			{
			final var generator = new WebSiteGenerator();

			generator.addEventListener(new IWebSiteGenerator.IEventListener()
				{
				@Override
				public void run(WebSiteGeneratorEvent event)
					{
					System.out.println("RUN");
					}

				@Override
				public void walk(WebSiteGeneratorEvent event)
					{
					System.out.println("WALK");
					}
				});

			//generator.getConfiguration("sd");

			generator.run();

			generator.walk(Paths.get("../cdpi.github.io/temp/Mot & Machine"), path -> {});

			//.devMarkdownToHTML(Paths.get("../cdpi.github.io/temp/Mot & Machine"));
			}
		catch (Exception ex)
			{
			ex.printStackTrace();
			}
		}
	}
