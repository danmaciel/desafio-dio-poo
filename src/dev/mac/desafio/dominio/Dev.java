package dev.mac.desafio.dominio;

import java.util.*;

public class Dev {

    private String nome;
    private Set<Conteudo> conteudoInscrito = new LinkedHashSet<>();

    public void setConteudoInscrito(Set<Conteudo> conteudoInscrito) {
        this.conteudoInscrito = conteudoInscrito;
    }

    public void setConteudoConcluidos(Set<Conteudo> conteudoConcluidos) {
        this.conteudoConcluidos = conteudoConcluidos;
    }

    private Set<Conteudo> conteudoConcluidos = new LinkedHashSet<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudoInscrito() {
        return conteudoInscrito;
    }

    public void inscreverEmBootCamp(final Bootcamp bootcamp) {
        this.conteudoInscrito = new LinkedHashSet<>(bootcamp.getConteudos());
        bootcamp.getDevs().add(this);
    }

    public Set<Conteudo> getConteudoConcluidos() {
        return conteudoConcluidos;
    }

    public void progredir() {
        Optional<Conteudo> conteudo = conteudoInscrito.stream().findFirst();
        if(!conteudo.isPresent()){
           System.err.println("Vocẽ não está inscrito em nenhum conteúdo!");
           return;
        }

        conteudoConcluidos.add(conteudo.get());
        conteudoInscrito.remove(conteudo.get());

    }

    public double calcularTotalXp(){
        return conteudoConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXP)
                .sum();
    }

    @Override
    public String toString() {
        return "Bootcamp{" +
                "nome='" + nome + '\'' +
                ", conteudoInscrito=" + conteudoInscrito +
                ", conteudoConcluidos=" + conteudoConcluidos +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudoInscrito, dev.conteudoInscrito) && Objects.equals(conteudoConcluidos, dev.conteudoConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudoInscrito, conteudoConcluidos);
    }
}
