package documin.documento.visoes;

import documin.documento.Documento;

import java.util.ArrayList;

public class Completa extends Visao {
    public Completa(Documento doc) {
        super(doc);
    }

    @Override
    public String[] gerarRepresentacao() {
        ArrayList<String> visoes = new ArrayList<>();
        for (int i = 0; i < doc.getQtdElementos(); i++) {
            visoes.add(doc.gerarRepresentacaoCompleta(i));
        }
        return visoes.toArray(new String[0]);
    }
}
