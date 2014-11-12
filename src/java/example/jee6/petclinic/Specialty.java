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
@Table(name = "specialties", catalog = "petclinic", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Specialty.findAll", query = "SELECT s FROM Specialty s"),
    @NamedQuery(name = "Specialty.findById", query = "SELECT s FROM Specialty s WHERE s.id = :id"),
    @NamedQuery(name = "Specialty.findByName", query = "SELECT s FROM Specialty s WHERE s.name = :name")})
public class Specialty implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Size(max = 80)
    @Column(length = 80)
    private String name;
    @ManyToMany(mappedBy = "specialtyCollection")
    private Collection<Vet> vetCollection;

    public Specialty() {
    }

    public Specialty(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Vet> getVetCollection() {
        return vetCollection;
    }

    public void setVetCollection(Collection<Vet> vetCollection) {
        this.vetCollection = vetCollection;
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
        if (!(object instanceof Specialty)) {
            return false;
        }
        Specialty other = (Specialty) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "example.jee6.petclinic2.Specialty[ id=" + id + " ]";
    }
    
}
