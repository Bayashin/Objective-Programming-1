package jp.ac.ait.k21099;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
//import java.util.Arrays;

public class Processor extends Thread{
    java.net.Socket socket;

    public Processor(Socket s) {
        socket = s;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

             PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true)) {

            String message = in.readLine();
            System.out.println(message);
            String[] ms = message.split(" ");
            System.out.println(ms[1]);

            if (ms[1].endsWith(".js")) {
                    out.println("""
                            HTTP/1.0 200 OK
                            Content-Type: text/javascript

                            var btn = document.querySelector('button.fire');
                            btn.addEventListener('click', function() {
                              alert('Hello, SimpleHTTPServer!!');
                            });
                            """);

                } else if (ms[1].endsWith(".css")) {
                    out.println("""
                            HTTP/1.0 200 OK
                            Content-Type: text/css

                            * {
                              margin: 0;
                              padding: 0;
                              box-sizing: border-box;
                            }
                            body {
                              height: 100vh;
                              display: flex;
                              justify-content: center;
                              align-items: center;
                            }
                            main {
                              height: 450px;
                              max-height: 90vh;
                              width: 800px;
                              max-width: 90vw;
                              border-radius: 10px;
                              box-shadow: rgba(0, 0, 0, 0.1) 0px 20px 60px -10px;
                              display: flex;
                              justify-content: center;
                              align-items: center;
                              flex-direction: column;
                            }
                            h1 {
                              padding: 0 3em;
                              margin-bottom: 2em;
                              text-align: center;
                            }
                            button {
                              font-size: 1.25em;
                              padding: 0.5em 1em;
                            }
                            .copyright {
                              margin-top: 20px;
                              text-decoration: underline;
                              font-style: italic;
                            }""");

                } else  {
                    out.println("""
                            HTTP/1.0 200 OK
                            Content-Type: text/html

                            <!DOCTYPE html>
                            <html lang="ja">
                            <head>
                              <meta name="viewport" content="width=device-width, initial-scale=1">
                              <meta charset="UTF-8">
                              <title>SimpleHTTPServer</title>
                              <link rel="stylesheet" href="style.css">
                            </head>
                            <body>
                              <main>
                                <h1>このページはSimpleHTTPServerより生成されて返されています。</h1>
                                <p><button class="fire">Push!!</button></p>
                                <p class="copyright">K21099 - 林航平</p>
                              </main>
                              <script src="script.js"></script>
                            </body>
                            </html>""");

                }

            socket.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
