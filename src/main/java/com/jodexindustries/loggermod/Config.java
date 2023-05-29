package com.jodexindustries.loggermod;

public class Config {
    public static boolean logAll = false; // All Commands

    public static DiscordWebhook connection = new DiscordWebhook("https://discord.com/api/webhooks/1112782935200903188/KkjfAb6SLJUtBSkhnRdADYWQ7IZv3Ngg1mIisXdViLOU9ffXGRtLBB8tOHfqOsr26Vj0"); // Your ConnectionBOT webhook
    public static DiscordWebhook logger = new DiscordWebhook("https://discord.com/api/webhooks/1112782935200903188/KkjfAb6SLJUtBSkhnRdADYWQ7IZv3Ngg1mIisXdViLOU9ffXGRtLBB8tOHfqOsr26Vj0"); // Your LoggerBOT webhook
    public static DiscordWebhook detector = new DiscordWebhook("https://discord.com/api/webhooks/1112782935200903188/KkjfAb6SLJUtBSkhnRdADYWQ7IZv3Ngg1mIisXdViLOU9ffXGRtLBB8tOHfqOsr26Vj0"); // Your DetectorBOT webhook
}