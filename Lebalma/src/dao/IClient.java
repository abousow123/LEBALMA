package dao;

import java.util.List;

import entity.Client;

public interface IClient {
	public void addClient(Client c) ;
	public void delClient(int cni) ;
	public List<Client> getClients();
	public Client getClient(int cni) ;
	public void updateClient(int cni,Client c) ;

}
