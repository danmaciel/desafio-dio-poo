import dev.mac.desafio.dominio.Bootcamp;
import dev.mac.desafio.dominio.Curso;
import dev.mac.desafio.dominio.Dev;
import dev.mac.desafio.dominio.Mentoria;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Curso curso1 = new Curso();
        curso1.setTitulo("Java");
        curso1.setDescricao("deescricao do curso de java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso de Js");
        curso2.setDescricao("ddescricao do curso de Js");
        curso2.setCargaHoraria(4);

        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("Mentoria Java");
        mentoria1.setDescricao("descricao da mentoria de Java");
        mentoria1.setData(LocalDate.now());

        Mentoria mentoria2 = new Mentoria();
        mentoria2.setTitulo("Mentoria Js");
        mentoria2.setDescricao("descricao da mentoria de Js");
        mentoria2.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descricao Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria1);

        Dev camila = new Dev();
        camila.setNome("Camila");
        camila.inscreverEmBootCamp(bootcamp);
        System.out.println("Conteudos inscritos Camila: "+camila.getConteudoInscrito());
        camila.progredir();
        camila.progredir();
        System.out.println("-");
        System.out.println("Conteudos inscritos Camila: "+camila.getConteudoInscrito());
        System.out.println("Conteudos Concluídos Camila: "+camila.getConteudoConcluidos());
        System.out.println("Xp: "+camila.calcularTotalXp());

        System.out.println("-------------------");

        Dev joao = new Dev();
        joao.setNome("João");
        joao.inscreverEmBootCamp(bootcamp);
        System.out.println("Conteudos inscritos João: "+joao.getConteudoInscrito());
        joao.progredir();
        joao.progredir();
        joao.progredir();
        System.out.println("-");
        System.out.println("Conteudos inscritos João: "+joao.getConteudoInscrito());
        System.out.println("Conteudos Concluídos João: "+joao.getConteudoConcluidos());
        System.out.println("Xp: "+joao.calcularTotalXp());

    }
}