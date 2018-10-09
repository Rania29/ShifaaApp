package entity.domain;

import entity.domain.ClinicList;
import entity.domain.ClinicService;
import entity.domain.Doctor;
import entity.domain.Hospital;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-09T22:32:56")
@StaticMetamodel(Clinic.class)
public class Clinic_ { 

    public static volatile SingularAttribute<Clinic, String> image;
    public static volatile ListAttribute<Clinic, ClinicService> clinicServices;
    public static volatile ListAttribute<Clinic, Doctor> doctors;
    public static volatile SingularAttribute<Clinic, String> workingDaysHours;
    public static volatile SingularAttribute<Clinic, ClinicList> name;
    public static volatile SingularAttribute<Clinic, Long> id;
    public static volatile SingularAttribute<Clinic, Hospital> hospital;

}