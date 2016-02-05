package application;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.NamespaceManager;
import com.google.appengine.api.datastore.*;

public class Datastore extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		if(NamespaceManager.get() == null){
			getServletContext().getRequestDispatcher("/choixDuFiltre.jsp").forward(req, resp);
		}
		else {

			String nom = req.getParameter("nom");
			String prenom = req.getParameter("prenom");

			String nameSpace = req.getParameter("etablissement");
			String currentNameSpace = NamespaceManager.get();
			System.out.println("doFilter : entre, currentNameSpace : " + currentNameSpace + ", nameSpace : " + nameSpace);

			DatastoreService dataStore = DatastoreServiceFactory.getDatastoreService();

			if (nom != null || prenom != null){

				//ajoute le visiteur
				Transaction tx = dataStore.beginTransaction();
				Entity person = new Entity("Personne");
				person.setProperty("nom", nom);
				person.setProperty("prenom", prenom);
				dataStore.put(person);
				tx.commit();
			} 

			//récupère la liste des visiteurs
			ArrayList<String> prenoms = new ArrayList<String>();
			ArrayList<String> noms = new ArrayList<String>();
			Query query = new Query("Personne");
			PreparedQuery pq = dataStore.prepare(query);
			for(Entity e: pq.asIterable()){
				prenoms.add((String) e.getProperty("prenom"));
				noms.add((String) e.getProperty("nom"));
			}

			//affiche la liste
			req.setAttribute("prenoms", prenoms);
			req.setAttribute("noms", noms);
			System.out.println("prenoms : " + prenoms + ", noms : " + noms);
			getServletContext().getRequestDispatcher("/formulaireNomPrenom.jsp").forward(req, resp);

		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doGet(request, response);
	}
}
