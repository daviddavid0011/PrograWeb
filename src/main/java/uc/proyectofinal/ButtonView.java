/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uc.proyectofinal;

import controller.ClienteController;
import facade.ClienteFacade;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
public class ButtonView {

    @EJB
    private ClienteFacade cl;

    public void buttonAction(ActionEvent actionEvent) {
        addMessage("Welcome to Primefaces!!");
        actualizarBD();

    }

    public void actualizarBD() {
        ClienteWS cws = new ClienteWS();

//        for (int i = 0; i < Integer.parseInt(cws.countREST()); i++) {
//            String val=(i+1)+"";
//            Cliente cliente=cws.find_XML(Cliente.class, val);
//            cl.remove(cliente);
//        }
        List<Cliente> clientes = cl.findAll();
        List<Integer> existentes = new ArrayList<>();
        for (int i = 0; i < clientes.size(); i++) {
            existentes.add(clientes.get(i).getIdCliente());
        }
        for (int i = 0; i < Integer.parseInt(cws.countREST()); i++) {

            String val = (i + 1) + "";
            if (!existentes.contains(val)) {
                Cliente cliente = cws.find_XML(Cliente.class, val);
                cl.create(cliente);
                
            }

        }

    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
