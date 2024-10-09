/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticaordenacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 10698079663
 */
public class PraticaOrdenacao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String path = "dadosConcurso.csv";
        
        
        List<Candidato> listCand = new ArrayList<Candidato>();
        InsertionSort<Candidato> issrt = new InsertionSort<>();
        
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            line = br.readLine();
            while(line != null){
                
                String[] v = line.split(",");
                int id = Integer.parseInt(v[0]);
                String nome = v[1];
                String dataNascimento = v[2];
                Integer nota = Integer.parseInt(v[3]);
                
                LocalDate dataNascimento2 = LocalDate.parse(dataNascimento, formatador);
                
                Candidato c = new Candidato(id, nome, dataNascimento2, nota);
                
                
            
                listCand.add(c);
                
                line = br.readLine();
                }
            System.out.println("TESTE");
            Candidato[] vetorCandidatos = new Candidato[listCand.size()];
            int i = 0;
            for(Candidato c: listCand){
                vetorCandidatos[i] = c;
                i++;
            }
            
            issrt.sort(vetorCandidatos);
            
            for(Candidato c: vetorCandidatos){
                System.out.println(c.toString());
            }
        }
        catch(IOException e){
            
            System.out.println("ERRO:"+e.getMessage());
            
        }
        
    }
}
