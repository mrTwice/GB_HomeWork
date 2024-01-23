## Задача
    
        Реализовать отправку вриватных сообщений.

Метод для выделения имени контакта из сообщения:



    private String getNameForPrivatMessage(String message){
            int spaceIndex = message.indexOf(' ');
            int spaceIndex2 = message.indexOf(' ', spaceIndex + 1);
            int at = message.indexOf('@');
            String nameInMsg = message.substring(at+1, spaceIndex2);
        return nameInMsg;
    }



Переработанный метод рассылки сообщений который проверяет наличия в сообщении символа "@", и если таковой присутствует на определенной позиции программа проваливается в условие которое определяет отправку приватных сообщений конкретному пользователю.

        private void broadcastMessage(String message) {
        if(message.contains("@") && message.charAt(message.indexOf(' ')+1)=='@'){ // проверка, есть ли в сообщении обращение к какому-то клиенту
            for (ClientManager client : clients) {
                try {
                    if (client.name.equals(getNameForPrivatMessage(message))) {
                        client.bufferedWriter.write(message);
                        client.bufferedWriter.newLine();
                        client.bufferedWriter.flush();
                    }
                } catch (IOException e) {
                    closeEverything(socket, bufferedReader, bufferedWriter);
                }
            }
        } else {
            for (ClientManager client : clients) {
                try {
                    if (!client.name.equals(name) && message != null) {
                        client.bufferedWriter.write(message);
                        client.bufferedWriter.newLine();
                        client.bufferedWriter.flush();
                    }
                } catch (IOException e) {
                    closeEverything(socket, bufferedReader, bufferedWriter);
                }
            }
        }
    }