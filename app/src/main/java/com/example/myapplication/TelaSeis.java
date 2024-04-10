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
                "Neil Gaiman é conhecido por suas obras de fantasia e ficção científica, como 'Deuses Americanos' e 'Sandman'.",
                "Chimamanda Ngozi Adichie é uma autora nigeriana cujas obras incluem 'Hibisco Roxo' e 'Americanah'.",
                "Gillian Flynn é uma autora de suspense conhecida por 'Garota Exemplar' e 'Objetos Cortantes'.",
                "Haruki Murakami é um escritor japonês cujas obras mesclam elementos de realismo mágico e filosofia, incluindo '1Q84' e 'Norwegian Wood'.",
                "Elena Ferrante é o pseudônimo de uma autora italiana, conhecida por sua série de livros 'A Amiga Genial'.",
                "Ta-Nehisi Coates é um escritor e jornalista americano, autor de 'Entre o Mundo e Eu' e 'O Chamado do Cuco'.",
                "Celeste Ng é uma autora americana cujas obras incluem 'Tudo o Que Nunca Contei' e 'Pequenos Incêndios por Toda Parte'.",
                // Adicione mais autores contemporâneos conforme necessário
        };
        return responses[new Random().nextInt(responses.length)];
    }


    // Método para gerar uma resposta aleatória sobre enredo
    private String generateRandomPlotResponse() {
        String[] responses = {
                "Em 'A Coragem de Ser Imperfeito', Brené Brown explora a importância da vulnerabilidade e da autenticidade para viver uma vida plena e significativa.",
                "No livro 'Educated' (Educação), Tara Westover relata sua jornada extraordinária de crescer em uma família extremamente religiosa e abusiva para se tornar uma acadêmica de sucesso.",
                "O enredo de 'Where the Crawdads Sing' (A Cidade dos Pássaros) segue a história de Kya Clark, uma jovem que cresce isolada na natureza selvagem da Carolina do Norte e se torna uma suspeita de assassinato.",
                "Em 'The Silent Patient' (A Paciente Silenciosa), de Alex Michaelides, um psicoterapeuta fica obcecado em desvendar o mistério por trás do silêncio de uma paciente que cometeu um assassinato brutal.",
                "O livro 'The Water Dancer' (O Chamado do Cuco), de Ta-Nehisi Coates, combina elementos de realismo mágico e história afro-americana para contar a história de um jovem escravizado com habilidades sobrenaturais.",
                "Em 'Normal People' (Pessoas Normais), Sally Rooney explora o relacionamento complexo e tumultuado entre dois jovens irlandeses ao longo de vários anos.",
                "O enredo de 'The Nickel Boys' (Garotos de Lugar Nenhum), de Colson Whitehead, segue a história de Elwood Curtis, um adolescente negro que é enviado para uma escola de reformatório na Flórida dos anos 1960.",
                "Em 'An Absolutely Remarkable Thing' (Uma Coisa Absolutamente Incrível), Hank Green conta a história de uma jovem que se torna uma sensação da internet após descobrir uma escultura alienígena.",
                "O livro 'My Sister, the Serial Killer' (Minha Irmã, a Serial Killer), de Oyinkan Braithwaite, é uma sátira afiada e sombria que segue uma mulher que ajuda a encobrir os assassinatos cometidos por sua irmã.",
                "Em 'Daisy Jones & The Six', Taylor Jenkins Reid narra a ascensão e queda de uma banda de rock fictícia nos anos 1970, em um formato de entrevista que dá vida aos personagens e ao ambiente da época.",
                // Adicione mais respostas conforme necessário
        };
        return responses[new Random().nextInt(responses.length)];
    }


    // Método para gerar uma resposta aleatória sobre lista de romance
    private String generateRandomRomanceListResponse() {
        String[] responses = {
                "A Cinco Passos de Você, de Rachael Lippincott",
                "O Sol é Para Todos, de Harper Lee",
                "Louco Amor, de Paula Hawkins",
                "Nove Desconhecidos, de Liane Moriarty",
                "O Amor nos Tempos de #likes, de Ana Lúcia Merege",
                "Uma Curva No Tempo, de Dani Atkins",
                "Três Coisas Sobre Você, de Julie Buxbaum",
                "A Garota do Calendário (série), de Audrey Carlan",
                "O Último Adeus, de Abbi Glines",
                "Meus Dias Com Você, de Clare Swatman",
                "Minha História Para Contar, de Juliana Parrini",
                "Um de Nós Está Mentindo, de Karen M. McManus",
                "O Casal Que Mora ao Lado, de Shari Lapena",
                "Beleza Perdida, de Amy Harmon",
                "Meus Dias Com Você, de Clare Swatman",
                // Adicione mais romances conforme necessário
        };
        return "Aqui estão alguns romances recomendados mais atuais: " + responses[new Random().nextInt(responses.length)];
    }



    // Método para gerar uma resposta aleatória sobre livros de fantasia
    private String generateRandomFantasyBookResponse() {
        String[] responses = {
                "Corte de Espinhos e Rosas, de Sarah J. Maas, é o primeiro livro de uma série de fantasia cheia de romance e aventura.",
                "Trono de Vidro, de Sarah J. Maas, é o primeiro livro de uma série que acompanha uma assassina em um mundo de magia e intrigas.",
                "Filha do Império, de Raymond E. Feist e Janny Wurts, é o primeiro livro de uma trilogia de fantasia épica com uma protagonista forte e inteligente.",
                "O Nome do Vento, de Patrick Rothfuss, é uma história envolvente sobre um músico prodígio em busca de conhecimento e vingança.",
                "Six of Crows, de Leigh Bardugo, é o primeiro livro de uma duologia de fantasia ambientada em um mundo de gangues e magia.",
                "Feita de Fumaça e Osso, de Laini Taylor, é o primeiro livro de uma trilogia que mistura fantasia e mitologia em uma história de amor e guerra.",
                "Nona Casa, de Leigh Bardugo, é o primeiro livro de uma série que combina elementos de fantasia e mistério ambientada em uma universidade secreta.",
                "A Rainha Vermelha, de Victoria Aveyard, é o primeiro livro de uma série distópica com poderes sobrenaturais e revolução política.",
                "Sombra e Ossos, de Leigh Bardugo, é o primeiro livro de uma trilogia de fantasia que se passa em um mundo inspirado na Rússia czarista.",
                "A Canção do Sangue, de Anthony Ryan, é o primeiro livro de uma trilogia de fantasia épica com dragões e intrigas políticas.",
                "A Guerra do Velho, de Joe Abercrombie, é o primeiro livro de uma trilogia de fantasia sombria e brutal.",
                "O Imperador de Todos os Males, de Brandon Sanderson, é o primeiro livro de uma série de fantasia épica que se passa em um mundo destruído pela guerra.",
                "A Queda dos Reinos, de Morgan Rhodes, é o primeiro livro de uma série de fantasia cheia de intrigas palacianas e batalhas épicas.",
                "Uma Chama Entre as Cinzas, de Sabaa Tahir, é o primeiro livro de uma série que mistura fantasia e inspiração histórica em um mundo de opressão e rebelião.",
                "Ruína e Ascensão, de Leigh Bardugo, é o segundo livro da série que mistura fantasia e mistério em uma universidade secreta.",
                "A Prisão do Rei, de Victoria Aveyard, é o terceiro livro da série A Rainha Vermelha, que combina poderes sobrenaturais e intrigas políticas.",
                "Trono Destruído, de Victoria Aveyard, é o quarto e último livro da série A Rainha Vermelha, que conclui a saga distópica com revolução e traição.",
                "Filhos do Éden: Anjos da Morte, de Eduardo Spohr, é o primeiro livro de uma série que mistura fantasia, mitologia e religião em um mundo de anjos e demônios.",
                "A Escolha dos Três, de Stephen King, é o segundo livro da série A Torre Negra, que mistura elementos de fantasia, ficção científica e faroeste.",
                "Uma Sombra na Floresta, de J.R. Johansson, é o primeiro livro de uma série que combina fantasia e mistério em um mundo onde os sonhos são reais.",
                // Adicione mais respostas conforme necessário
        };
        return responses[new Random().nextInt(responses.length)];
    }


    // Método para gerar uma resposta aleatória sobre livros de terror
    private String generateRandomHorrorBookResponse() {
        String[] responses = {
                "Bom dia, Verônica, de Raphael Montes e Ilana Casoy, é um thriller de terror psicológico que acompanha uma policial que se envolve em uma investigação perturbadora.",
                "A Mulher na Janela, de A.J. Finn, é um suspense psicológico que mergulha nas profundezas da mente de uma mulher que testemunha um crime enquanto espia seus vizinhos.",
                "Coraline, de Neil Gaiman, é um conto sombrio e surreal sobre uma menina que descobre uma versão alternativa de sua vida atrás de uma porta secreta.",
                "O Vilarejo, de Raphael Montes, é uma coletânea de contos de horror que exploram os medos mais profundos da humanidade em um vilarejo isolado.",
                "Bird Box, de Josh Malerman, é um thriller psicológico sobre uma mãe e seus filhos que precisam sobreviver em um mundo onde olhar para fora pode levar à loucura e à morte.",
                "Horror na Colina de Darrington, de Marcus Barcelos, é um romance de terror que acompanha um grupo de amigos que enfrenta eventos sobrenaturais em uma cidade isolada.",
                "Os Condenados, de Andrew Pyper, é um thriller sobrenatural que segue um escritor que se envolve em uma investigação sobre um antigo hospício assombrado.",
                "O Circo Mecânico Tresaulti, de Genevieve Valentine, é um romance de horror que se passa em um circo itinerante onde artistas têm corpos modificados e atrações sobrenaturais.",
                "A Mulher de Preto, de Susan Hill, é um clássico moderno do horror gótico que conta a história de um advogado que encontra uma assombração em uma cidade isolada.",
                "Asylum, de Madeleine Roux, é o primeiro livro de uma série de terror que se passa em um antigo hospital psiquiátrico repleto de segredos sombrios.",
                // Adicione mais respostas conforme necessário
        };
        return responses[new Random().nextInt(responses.length)];
    }


    // Método para gerar uma resposta aleatória sobre livros de ficção científica
    private String generateRandomSciFiBookResponse() {
        String[] responses = {
                "A Longa Viagem a um Pequeno Planeta Hostil, de Becky Chambers, é o primeiro livro de uma série que explora o cotidiano de uma tripulação espacial diversificada.",
                "As Máquinas de Lágrimas, de Stephen Graham Jones, é um romance de ficção científica que mistura elementos de horror e viagem no tempo.",
                "A Mão Esquerda da Escuridão, de Ursula K. Le Guin, é um clássico da ficção científica que explora questões de gênero e política em um planeta alienígena.",
                "O Livro do Juízo Final, de Connie Willis, é uma história de viagem no tempo ambientada durante a Segunda Guerra Mundial, com elementos de romance e suspense.",
                "O Poder, de Naomi Alderman, é um romance distópico que imagina um mundo onde as mulheres desenvolvem o poder de infligir dor e morte.",
                "Seveneves: Sete Evas, de Neal Stephenson, é um épico de ficção científica que explora os esforços da humanidade para sobreviver após a destruição da Lua.",
                "Lunar Park, de Bret Easton Ellis, é um romance de ficção científica que mistura elementos autobiográficos com elementos de horror e sátira.",
                "A Marinha das Estrelas, de David Brin, é o primeiro livro de uma série que acompanha uma civilização galáctica em conflito com uma ameaça alienígena.",
                "A Fúria dos Reis, de James S.A. Corey, é o segundo livro da série The Expanse, que combina elementos de ficção científica, drama político e aventura espacial.",
                "O Problema dos Três Corpos, de Liu Cixin, é o primeiro livro da trilogia Remembrance of Earth's Past, que combina ficção científica hard com elementos de suspense e filosofia.",
                // Adicione mais respostas conforme necessário
        };
        return responses[new Random().nextInt(responses.length)];
    }


    // Método para gerar uma resposta aleatória sobre podcasts
    private String generateRandomPodcastResponse() {
        String[] responses = {
                "O podcast Entre Fraldas e Livros aborda leituras atuais e dicas de literatura infantil para pais e crianças.",
                "No podcast Leituras do Mercado, você encontrará entrevistas com autores contemporâneos e análises de obras recentes.",
                "O podcast Prosa de Biblioteca discute lançamentos literários, resenhas de livros e entrevistas com escritores emergentes.",
                "No podcast Café com Livros, você pode ouvir conversas descontraídas sobre os lançamentos mais quentes do mundo literário.",
                "O podcast Leituras da Bela oferece análises aprofundadas sobre livros contemporâneos e clássicos da literatura mundial.",
                "No podcast Clube do Livro, você encontrará recomendações mensais de livros baseadas em temas atuais e discussões sobre leituras recentes.",
                "O podcast Livros e Café traz entrevistas com autores nacionais e internacionais, além de análises de obras contemporâneas.",
                "No podcast Páginas Abertas, você pode ouvir discussões sobre os lançamentos mais recentes da literatura brasileira e mundial.",
                "O podcast Entre Páginas explora os bastidores da escrita e da publicação de livros, com foco em obras contemporâneas.",
                "No podcast Palavras Cruzadas, você encontrará debates sobre os temas mais quentes da literatura atual e clássica.",
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
                "Oi! Sinta-se à vontade para fazer qualquer pergunta relacionada a livros.",
                "Olá! Estou feliz em ajudar. Qual é o seu livro favorito?",
                "Oi! Você já leu algum livro interessante ultimamente?",
                "Olá! Estou disponível para discutir qualquer coisa relacionada a livros. Qual é o seu gênero literário preferido?",
                "Oi! Estou animado para conversar sobre livros. Qual é o último livro que você leu?",
                "Olá! Se precisar de recomendações de leitura, estou aqui para ajudar!",
                // Adicione mais respostas conforme necessário
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
