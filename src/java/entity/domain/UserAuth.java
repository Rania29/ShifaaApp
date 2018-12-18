package entity.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * @author sawad
 */
@Entity
public class UserAuth implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    private String name;

    @Basic
    private String password;

    @Basic
    private String email;

    @ManyToOne
    private Hospital hospital;

    @ManyToMany
    private List<GroupAuth> groupAuths;

    public UserAuth() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String username) {
        this.name = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Hospital getHospital() {
        return this.hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public List<GroupAuth> getGroupAuths() {
        if (groupAuths == null) {
            groupAuths = new ArrayList<>();
        }
        return this.groupAuths;
    }

    public void setGroupAuths(List<GroupAuth> groupAuths) {
        this.groupAuths = groupAuths;
    }

    public void addGroupAuth(GroupAuth groupAuth) {
        getGroupAuths().add(groupAuth);
        groupAuth.getUserAuths().add(this);
    }

    public void removeGroupAuth(GroupAuth groupAuth) {
        getGroupAuths().remove(groupAuth);
        groupAuth.getUserAuths().remove(this);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.password);
        hash = 59 * hash + Objects.hashCode(this.email);
        hash = 59 * hash + Objects.hashCode(this.hospital);
        hash = 59 * hash + Objects.hashCode(this.groupAuths);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserAuth other = (UserAuth) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.hospital, other.hospital)) {
            return false;
        }
        if (!Objects.equals(this.groupAuths, other.groupAuths)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "UserAuth{" + "username=" + name + '}';
    }

}
