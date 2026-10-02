import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;
import javafx.scene.Scene;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) { //O stage é o "Palco", basicamente é a janela princiapl padrão do windows. Posso mudar a minha Scene e ficar no Stage.

        //Primeiro vou definir as componentes da minha janela, ou seja, o que de fato "Interage" como usuário.
        //Por exemplo, um botão, campos de escolhas, lista de opções etc.
        Label tituloLabel = new Label("CÁLCULO DE MATRIZES");

        //Label responsável pela explicação
        Label explicacaoLabel = new Label("Esse programa cria um matriz de ordem predefinida pelo usuário com valores " +
        "aleatórios entre -10 e 10. Depois exibe o determinante respectivo daquela matriz e exibe o produtos das suas diagonais.");

        Label instrucaoLabel = new Label("Por favor, selecione a ordem da Matriz que será criada.");

        //Vou criar um grupo com togleGroup. Ele não é um objeto visual mas garante que apenas uma opção no grupo será marcada.
        //No caso, estou me referindo aos meus botões de opcções, RadioButtons;
        ToggleGroup ordemMatriz = new ToggleGroup();

        //Aqui está os meus radios buttons.
        RadioButton option1 = new RadioButton("Ordem 2");
        RadioButton option2 = new RadioButton("Ordem 3");
        RadioButton option3 = new RadioButton("Ordem 4");
        RadioButton option4 = new RadioButton("Ordem 5");

        //Com os botões criados agora basta que eu agrupe eles em um mesmo grupo, ou seja ao ToggleGroup
        option1.setToggleGroup(ordemMatriz);
        option2.setToggleGroup(ordemMatriz);
        option3.setToggleGroup(ordemMatriz);
        option4.setToggleGroup(ordemMatriz);

        //agora estou definindo que um botão ficará marcado por padrão. Já evita problemas depois.
        option1.setSelected(true);

        //Agora vou criar uma dinâmica bem interessante do JavaFX. Posso criar um botão e atribuir uma ação a ele (setButtuonAction)
        Button confirmarOpcao = new Button("Confirmar");

        confirmarOpcao.setOnAction(e -> {
            RadioButton selecionado = (RadioButton) ordemMatriz.getSelectedToggle();

            if (selecionado != null) {
                System.out.println("Deu certo! O caba escolheu a opção " + selecionado.getText());
            }

        });

        //Primeiro eu tenho que criar o Vbox, ele define a forma que os meus "atores" node ficarão disposto na tela
        //Pelo que entendi é o layout da minha Janela
        VBox layout = new VBox();
        layout.setSpacing(20); //Espaço sobre cada um dos meus componentes
        layout.setAlignment(Pos.CENTER); //Posicionamento central dos componentes

        //Como a parte principal está pronta, e já temos nossos principais componentes, vamos juntá-los no nosso layout
        layout.getChildren().addAll(
            tituloLabel,
            explicacaoLabel,
            instrucaoLabel,
            option1,
            option2,
            option3,
            option4,
            confirmarOpcao
        );

        //Criei uma cena como o meu layout. Nessa cena os meus Nodes criados aparecerão de acordo o Layout utilizado.
        Scene cena = new Scene(layout, 450, 450);

        //Aqui é a configuração final do meu sistema, defini a cena ao palco, o titulo e pedi para mostar.
        primaryStage.setScene(cena);
        primaryStage.setTitle("ATIVIDADE DE POO");
        primaryStage.show();
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}

