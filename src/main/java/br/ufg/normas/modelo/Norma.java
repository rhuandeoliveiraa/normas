package br.ufg.normas.modelo;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;

@Entity
@Table(name = "normas")
public class Norma implements Serializable {

    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Expose
    @Column
    private String nome;

    @Expose
    @Column(length = 5000)
    private String descricao;

    @Expose
    @Column(name = "dataCadastro")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "usuarios_normas",
            joinColumns = @JoinColumn(name = "normas_id"),
            inverseJoinColumns = @JoinColumn(name = "usuarios_id"))
    private java.util.Set<Usuario> usuarios = new HashSet<Usuario>();

   /* @Column
    private String arquivo;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Norma norma = (Norma) o;
        return Objects.equals(id, norma.id) &&
                Objects.equals(nome, norma.nome) &&
                Objects.equals(descricao, norma.descricao) &&
                Objects.equals(dataCadastro, norma.dataCadastro);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, nome, descricao, dataCadastro);
    }

    @Override
    public String toString() {
        return "Norma{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataCadastro=" + dataCadastro +
                '}';
    }
}
