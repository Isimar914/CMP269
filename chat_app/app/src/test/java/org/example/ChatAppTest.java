package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.net.Socket;

public class ChatAppTest {
   @Test
   public void testMessageIsNotEmpty() {
    String message = "Hello";
    assertFalse(message.isEmpty(), "Message should not be empty");
   }

   @Test
   public void testMessageContainsText() {
    String message = "Hello from ChatApp!";
    assertTrue(message.contains("ChatApp"));
   }

   @Test
   public void testUsernameIsAssigned() {
      ChatApp chatApp = new ChatApp();
      String username = "User1";
      assertNotNull(username);
   }

   @Test
   public void testServerConnection() {
      try {
         Socket socket = new Socket("localhost", 59001);
         assertTrue(socket.isConnected(), "Should be able to connect to the server");
         socket.close();
      } catch (Exception e) {
         throw new RuntimeException("Failed to connect to the server");
      }
   }
}
