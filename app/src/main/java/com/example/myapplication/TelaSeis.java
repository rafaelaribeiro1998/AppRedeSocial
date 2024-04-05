package com.example.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class TelaSeis extends AppCompatActivity {

    private EditText messageEditText;
    private TextView chatTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_seis);

        // Inicialização dos elementos da interface
        messageEditText = findViewById(R.id.messageEditText);
        chatTextView = findViewById(R.id.chatTextView);
        Button sendButton = findViewById(R.id.sendButton);

        // Configuração do botão de envio de mensagem
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });
    }

    // Método para enviar mensagem
    private void sendMessage() {
        final String message = messageEditText.getText().toString().trim();
        if (!message.isEmpty()) {
            String currentChat = chatTextView.getText().toString();
            currentChat += "Você: " + message + "\n";

            // Exibe mensagem do usuário
            chatTextView.setText(currentChat);
            messageEditText.getText().clear();

            // Verifica o tipo de pergunta e envia uma resposta correspondente
            String response = generateResponse(message);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    receiveMessage("Bot: " + response);
                }
            }, 1000); // Tempo de resposta simulado: 1 segundo
        }
    }

    // Método para gerar resposta com base na pergunta do usuário
    private String generateResponse(String message) {
        // Verifica o tipo de pergunta e gera uma resposta correspondente
        if (message.toLowerCase().contains("autor")) {
            return generateRandomAuthorResponse();
        } else if (message.toLowerCase().contains("enredo")) {
            return generateRandomPlotResponse();
        } else if (message.toLowerCase().contains("lista") && message.toLowerCase().contains("romance")) {
            return generateRandomRomanceListResponse();
        } else if (message.toLowerCase().contains("fantasia")) {
            return generateRandomFantasyBookResponse();
        } else if (message.toLowerCase().contains("terror") || message.toLowerCase().contains("horror")) {
            return generateRandomHorrorBookResponse();
        } else if (message.toLowerCase().contains("ficção científica") || message.toLowerCase().contains("ficção cientifica")) {
            return generateRandomSciFiBookResponse();
        } else if (message.toLowerCase().contains("podcast")) {
            return generateRandomPodcastResponse();
        } else {
            return generateRandomDefaultResponse();
        }
    }

    // Método para gerar uma resposta aleatória sobre autores
    private String generateRandomAuthorResponse() {
        String[] responses = {
                "Machado de Assis é um renomado autor brasileiro.",
                "J.K. Rowling é a autora da série Harry Potter.",
                "Stephen King é famoso por seus livros de terror e suspense.",
                // Adicione mais respostas conforme necessário
        };
        return responses[new Random().nextInt(responses.length)];
    }

    // Método para gerar uma resposta aleatória sobre enredo
    private String generateRandomPlotResponse() {
        String[] responses = {
                "O enredo de Dom Casmurro envolve questões de ciúmes e traição.",
                "Em O Senhor dos Anéis, uma sociedade busca destruir um anel mágico para evitar a dominação do mal.",
                // Adicione mais respostas conforme necessário
        };
        return responses[new Random().nextInt(responses.length)];
    }

    // Método para gerar uma resposta aleatória sobre lista de romance
    private String generateRandomRomanceListResponse() {
        String[] responses = {
                "Orgulho e Preconceito, de Jane Austen",
                "Como Eu Era Antes de Você, de Jojo Moyes",
                "Cem Anos de Solidão, de Gabriel García Márquez",
                // Adicione mais livros de romance conforme necessário
        };
        return "Aqui estão alguns livros de romance recomendados: " + responses[new Random().nextInt(responses.length)];
    }

    // Método para gerar uma resposta aleatória sobre livros de fantasia
    private String generateRandomFantasyBookResponse() {
        String[] responses = {
                "Harry Potter, de J.K. Rowling, é uma série de livros de fantasia muito popular.",
                "As Crônicas de Nárnia, de C.S. Lewis, são clássicos da literatura fantástica.",
                // Adicione mais respostas conforme necessário
        };
        return responses[new Random().nextInt(responses.length)];
    }

    // Método para gerar uma resposta aleatória sobre livros de terror
    private String generateRandomHorrorBookResponse() {
        String[] responses = {
                "It, de Stephen King, é um livro de terror clássico que foi adaptado para o cinema.",
                "O Exorcista, de William Peter Blatty, é um dos livros mais assustadores já escritos.",
                // Adicione mais respostas conforme necessário
        };
        return responses[new Random().nextInt(responses.length)];
    }

    // Método para gerar uma resposta aleatória sobre livros de ficção científica
    private String generateRandomSciFiBookResponse() {
        String[] responses = {
                "Fundação, de Isaac Asimov, é um clássico da ficção científica que explora o futuro da humanidade.",
                "O Guia do Mochileiro das Galáxias, de Douglas Adams, é uma série divertida e inteligente de ficção científica.",
                // Adicione mais respostas conforme necessário
        };
        return responses[new Random().nextInt(responses.length)];
    }

    // Método para gerar uma resposta aleatória sobre podcasts
    private String generateRandomPodcastResponse() {
        String[] responses = {
                "O podcast Leitor Cabuloso discute livros de diversos gêneros, incluindo fantasia, terror e ficção científica.",
                "No podcast Mundo Freak, você pode encontrar episódios sobre temas relacionados ao universo do terror e do sobrenatural.",
                // Adicione mais respostas conforme necessário
        };
        return responses[new Random().nextInt(responses.length)];
    }

    // Método para gerar uma resposta aleatória padrão
    private String generateRandomDefaultResponse() {
        String[] responses = {
                "Olá! Como posso ajudá-lo?",
                "Olá! Estou aqui para responder suas perguntas sobre livros.",
                "Oi! Que tipo de informação você está procurando?",
                "Olá! Estou pronto para ajudá-lo com suas dúvidas sobre livros.",
                "Oi! Sinta-se à vontade para fazer qualquer pergunta relacionada a livros."
        };
        return responses[new Random().nextInt(responses.length)];
    }


    // Método para receber mensagem e exibir na tela
    private void receiveMessage(String message) {
        String currentChat = chatTextView.getText().toString();
        currentChat += message + "\n";

        // Exibe mensagem de resposta
        chatTextView.setText(currentChat);
    }
}
