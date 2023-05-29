package com.jodexindustries.loggermod;

public class Config {
    public static boolean logAll = false; // All Commands

    public static DiscordWebhook connection = new DiscordWebhook(""); // Your ConnectionBOT webhook
    public static DiscordWebhook logger = new DiscordWebhook(""); // Your LoggerBOT webhook
    public static DiscordWebhook detector = new DiscordWebhook(""); // Your DetectorBOT webhook
}