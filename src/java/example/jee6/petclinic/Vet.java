/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.jee6.petclinic;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author EvgeniGordeev
 */
@Entity
@Table(name = "vets")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vet.findAll", query = "SELECT v FROM Vet v"),
    @NamedQuery(name = "Vet.findById", query = "SELECT v FROM Vet v WHERE v.id = :id"),
    @NamedQuery(name = "Vet.findByFirstName", query = "SELECT v FROM Vet v WHERE v.firstName = :firstName"),
    @NamedQuery(name = "Vet.findByLastName", query = "SELECT v FROM Vet v WHERE v.lastName = :lastName")})
public class Vet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Size(max = 30)
    @Column(name = "first_name", length = 30)
    private String firstName;
    @Size(max = 30)
    @Column(name = "last_name", length = 30)
    private String lastName;
    @JoinTable(name = "vet_specialties", joinColumns = {
        @JoinColumn(name = "vet_id", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "specialty_id", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private Collection<Specialty> specialtyCollection;

    public Vet() {
    }

    public Vet(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlTransient
    public Collection<Specialty> getSpecialtyCollection() {
        return specialtyCollection;
    }

    public void setSpecialtyCollection(Collection<Specialty> specialtyCollection) {
        this.specialtyCollection = specialtyCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vet)) {
            return false;
        }
        Vet other = (Vet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "example.jee6.petclinic2.Vet[ id=" + id + " ]";
    }
    
}
