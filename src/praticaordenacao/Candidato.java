/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praticaordenacao;

import java.time.LocalDate;

/**
 *
 * @author 10698079663
 */
public class Candidato implements Comparable<Candidato>{
    private String nome;
    private LocalDate dataNascimento;
    private Integer nota;
    private int id;

    public Candidato(int id, String nome, LocalDate dataNascimento, Integer nota) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.nota = nota;

    }



    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Candidato(String nome, LocalDate dataNasc){
        this.nome = nome;
        this.dataNascimento = dataNasc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    @Override
    public String toString(){
        return this.nome + ":" 
                + this.dataNascimento + " Nota: "
                +this.nota;
    }
    
    @Override
    public int compareTo(Candidato outroCandidato){
        int comparaNota = this.nota.compareTo(outroCandidato.getNota());
        if(comparaNota==0)// notas iguais
            return this.dataNascimento.compareTo(outroCandidato.getDataNascimento());
        
        return comparaNota;
    }
}
