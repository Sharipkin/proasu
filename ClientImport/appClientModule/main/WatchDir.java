package main;

import java.io.IOException;
import java.nio.file.*;


public class WatchDir {

	public static void main(String[] args) {
		
		Path path = Paths.get("d:\\Programming\\Java\\ki"); 
		WatchService watchService = null; 
        try { 
            watchService = path.getFileSystem().newWatchService(); 
            path.register(watchService, 
                    StandardWatchEventKinds.ENTRY_CREATE, 
                    StandardWatchEventKinds.ENTRY_DELETE, 
                    StandardWatchEventKinds.ENTRY_MODIFY); 
        } catch (IOException e1) { 
            e1.printStackTrace(); 
        } 
        // ����������� ���� 
        for (;;) { 
            WatchKey key = null; 
            try { 
                key = watchService.take(); 
            } catch (InterruptedException e) { 
                e.printStackTrace(); 
            } 
            // �������� ��� ������� ������� 
            for (WatchEvent event : key.pollEvents()) { 
                switch (event.kind().name()) { 
                case "OVERFLOW": 
                    System.out.println("We lost some events"); 
                    break; 
                case "ENTRY_CREATE": 
                    System.out.println("File " + event.context() 
                            + " is created!"); 
                    break; 
                case "ENTRY_MODIFY": 
                    System.out.println("File " + event.context() 
                            + " is modified!"); 
                    break; 
                case "ENTRY_DELETE": 
                    System.out.println("File " + event.context() 
                            + " is deleted!"); 
                    break; 
                } 
            } 
            // ����� ����� ����� ��� ��������� ����������� ����������� 
            key.reset(); 
        }

	}

}
