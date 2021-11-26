package ru.job4j.ood.lsp;

public class SocialNetwork extends Messenger {
    @Override
    public void sendMessage(Account account, String text) {
        System.out.println("сообщение отправлено");
    }
}
