/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import GUI.FrameAjouterService;
import dao.ZoneDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Super
 */
public class Service {

    ZoneDao zoneDAO = new ZoneDao();
    ResultSet rsName = null;
    private int id;
    private String nomService;
    private String description;
    private String type;
    private String etat;
    private Date dateAjout;
    private int zone;
    private String zoneName;

    public Service() {
    }

    public Service(int id, String nomService, String description, String type, String etat, Date dateAjout, int zone) {
        this.id = id;
        this.nomService = nomService;
        this.description = description;
        this.type = type;
        this.etat = etat;
        this.dateAjout = dateAjout;
        this.zone = zone;
    }

    public Service(int id, String nomService, String description, String type, String etat, Date dateAjout) {
        this.id = id;
        this.nomService = nomService;
        this.description = description;
        this.type = type;
        this.etat = etat;
        this.dateAjout = dateAjout;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomService() {
        return nomService;
    }

    public void setNomService(String nomService) {
        this.nomService = nomService;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    public int getZone() {
        return zone;
    }

    public String getZoneName() {
        try {
            rsName = zoneDAO.getZoneById(zone);
            while (rsName.next()) {
                zoneName = rsName.getNString(1);

            }//this.setResizable(false);
        } catch (SQLException ex) {
            Logger.getLogger(FrameAjouterService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return zoneName;

    }

    public void setZone(int zone) {
        this.zone = zone;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Service other = (Service) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nomService, other.nomService)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.etat, other.etat)) {
            return false;
        }
        if (!Objects.equals(this.dateAjout, other.dateAjout)) {
            return false;
        }
        if (!Objects.equals(this.zone, other.zone)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Service{" + "id=" + id + ", nomService=" + nomService + ", description=" + description + ", type=" + type + ", etat=" + etat + ", dateAjout=" + dateAjout + ", zone=" + zone + '}';
    }

}
