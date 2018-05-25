package ilusoesindustriais.com.apptinta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textTamanho;
    private EditText textQuantidadeLitros;
    private EditText textValorLata;
    private EditText textValorGalao;
    private EditText textMelhor;
    private Button botaoCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textTamanho = findViewById(R.id.textTamanhoId);
        textQuantidadeLitros = findViewById(R.id.textQuantidadeLitrosId);
        textValorLata = findViewById(R.id.textValorLataId);
        textValorGalao = findViewById(R.id.textValorGalaoId);
        textMelhor = findViewById(R.id.textMelhorId);
        botaoCalcular = findViewById(R.id.botaoCalcularId);

        botaoCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tamanhoArea = textTamanho.getText().toString();
                Double valorArea = Double.parseDouble(tamanhoArea);

                //Calculando a quantidade de litros
                Double litros = valorArea / 6;

                //Calculando a quantidade de latas e galões
                Double quantidadeLata = litros / 18;
                Double valorLata = (quantidadeLata * 80);

                Double quantidadeGalao = litros / 3.6;
                Double valorGalao = (quantidadeGalao * 25);

                //Calculando Melhor Custo
                //A combinação de melhor resultado é sempre composta do máximo de latas possível + 1 galão
                Double valorMelhor = (Math.ceil(valorLata) - 1) + 25;  //-1 porque foi arredondado para cima

                //Mudando para String e mostrando na tela
                String valorLitros = litros.toString();
                textQuantidadeLitros.setText(valorLitros);

                String valorLataTela = valorLata.toString();
                textValorLata.setText("R$: " + valorLataTela);

                String valorGalaoTela = valorGalao.toString();
                textValorGalao.setText("R$: " + valorGalaoTela);

                String valorMelhorTela = valorMelhor.toString();
                textMelhor.setText("R$: " + valorMelhorTela);

                Toast.makeText(MainActivity.this,"Cálculo efetuado com sucesso!", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
