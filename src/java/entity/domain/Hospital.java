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
import javax.persistence.OneToMany;

@Entity
public class Hospital implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Basic
    private String name;

    @Basic
    private String inArabic;

    @Basic
    private String phoneNo;

    @Basic
    private String email;

    @Basic
    private String locationMap;

    @Basic
    private String workingDaysHours;

    @ManyToOne
    private Area area;

    @OneToMany(mappedBy = "hospital")
    private List<Clinic> clinics;

    @OneToMany(mappedBy = "hospital")
    private List<HospitalImage> hospitalImages;

//    @ManyToMany(mappedBy = "hospitals")
    @ManyToMany
    private List<Insurance> insurances;

    public Hospital() {
    }

    public String getInArabic() {
        return inArabic;
    }

    public void setInArabic(String inArabic) {
        this.inArabic = inArabic;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return this.phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocationMap() {
        return this.locationMap;
    }

    public void setLocationMap(String locationMap) {
        this.locationMap = locationMap;
    }

    public String getWorkingDaysHours() {
        return this.workingDaysHours;
    }

    public void setWorkingDaysHours(String workingDaysHours) {
        this.workingDaysHours = workingDaysHours;
    }

    public Area getArea() {
        return this.area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public List<Clinic> getClinics() {
        if (clinics == null) {
            clinics = new ArrayList<>();
        }
        return this.clinics;
    }

    public void setClinics(List<Clinic> clinics) {
        this.clinics = clinics;
    }

    public void addClinic(Clinic clinic) {
        getClinics().add(clinic);
        clinic.setHospital(this);
    }

    public void removeClinic(Clinic clinic) {
        getClinics().remove(clinic);
        clinic.setHospital(null);
    }

    public List<HospitalImage> getHospitalImages() {
        if (hospitalImages == null) {
            hospitalImages = new ArrayList<>();
        }
        return this.hospitalImages;
    }

    public void setHospitalImages(List<HospitalImage> hospitalImages) {
        this.hospitalImages = hospitalImages;
    }

    public void addHospitalImage(HospitalImage hospitalImage) {
        getHospitalImages().add(hospitalImage);
        hospitalImage.setHospital(this);
    }

    public void removeHospitalImage(HospitalImage hospitalImage) {
        getHospitalImages().remove(hospitalImage);
        hospitalImage.setHospital(null);
    }

    public List<Insurance> getInsurances() {
        if (insurances == null) {
            insurances = new ArrayList<>();
        }
        return this.insurances;
    }

    public void setInsurances(List<Insurance> insurances) {
        this.insurances = insurances;
    }

    public void addInsurance(Insurance insurance) {
        getInsurances().add(insurance);
    }

    public void removeInsurance(Insurance insurance) {
        getInsurances().remove(insurance);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final Hospital other = (Hospital) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

}