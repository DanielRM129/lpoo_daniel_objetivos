package model;

public class Animal {
    private Long id;
    private String nome_animal;
    private int idade_animal;
    private String sexo_animal;

    public Animal() {
    }

    public Animal(Long id, String nome_animal, int idade_animal, String sexo_animal) {
        this.id = id;
        this.nome_animal = nome_animal;
        this.idade_animal = idade_animal;
        this.sexo_animal = sexo_animal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_animal() {
        return nome_animal;
    }

    public void setNome_animal(String nome_animal) {
        this.nome_animal = nome_animal;
    }

    public int getIdade_animal() {
        return idade_animal;
    }

    public void setIdade_animal(int idade_animal) {
        this.idade_animal = idade_animal;
    }

    public String getSexo_animal() {
        return sexo_animal;
    }

    public void setSexo_animal(String sexo_animal) {
        this.sexo_animal = sexo_animal;
    }

    @Override
    public String toString() {
        return "\nAnimal{" +
                "id=" + id +
                ", nome_animal='" + nome_animal + '\'' +
                ", idade_animal=" + idade_animal +
                ", sexo_animal=" + sexo_animal +
                '}';
    }
}
