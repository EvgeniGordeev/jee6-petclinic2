/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.jee6.petclinic;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author EvgeniGordeev
 */
@Entity
@Table(name = "owners")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Owner.findAll", query = "SELECT o FROM Owner o"),
        @NamedQuery(name = "Owner.findById", query = "SELECT o FROM Owner o WHERE o.id = :id"),
        @NamedQuery(name = "Owner.findByFirstName", query = "SELECT o FROM Owner o WHERE o.firstName = :firstName"),
        @NamedQuery(name = "Owner.findByLastName", query = "SELECT o FROM Owner o WHERE o.lastName = :lastName"),
        @NamedQuery(name = "Owner.findByAddress", query = "SELECT o FROM Owner o WHERE o.address = :address"),
        @NamedQuery(name = "Owner.findByCity", query = "SELECT o FROM Owner o WHERE o.city = :city"),
        @NamedQuery(name = "Owner.findByTelephone", query = "SELECT o FROM Owner o WHERE o.telephone = :telephone") })
public class Owner implements Serializable {
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
    @Size(max = 255)
    @Column(length = 255)
    private String address;
    @Size(max = 80)
    @Column(length = 80)
    private String city;
    @Size(max = 20)
    @Column(length = 20)
    private String telephone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerId")
    private Collection<Pet> petCollection;

    public Owner() {
    }

    public Owner(Integer id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @XmlTransient
    public Collection<Pet> getPetCollection() {
        return petCollection;
    }

    public void setPetCollection(Collection<Pet> petCollection) {
        this.petCollection = petCollection;
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
        if (!(object instanceof Owner)) {
            return false;
        }
        Owner other = (Owner) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }

}
