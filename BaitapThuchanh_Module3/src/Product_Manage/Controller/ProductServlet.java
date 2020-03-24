package Product_Manage.Controller;

import Product_Manage.Model.Product;
import Product_Manage.ProductService.ProductService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProductServlet",urlPatterns = {"/"})
public class ProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if(action == null){
            action= "";
        }
        switch (action){
            case "addProduct":
                addProduct(request,response);
                break;
            case "editProduct":
                editProduct(request,response);
                break;
            case "deleteProduct":
                deleteProduct(request,response);
                break;
            default:
                listProduct(request,response);
                break;
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action= "";
        }
        switch (action){
            case "editProduct":
                showEditProduct(request,response);
                break;
            case "deleteProduct":
                showDeleteProduct(request,response);
                break;
            case "addProduct":
                showAddProduct(request,response);
                break;
            default:
                listProduct(request,response);
                break;
        }
    }

    public void listProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProductService productService = new ProductService();
        ArrayList<Product> productList = productService.selectAllProduct();

        RequestDispatcher dispatcher = request.getRequestDispatcher("Product.jsp");
        //request.setAttribute("productList", productList);
        dispatcher.forward(request,response);

    }
    public void showEditProduct(HttpServletRequest request, HttpServletResponse response){
        int productId = Integer.parseInt(request.getParameter("Id"));
        ProductService productService = new ProductService();

        Product product = productService.findById(productId);

        RequestDispatcher dispatcher = request.getRequestDispatcher("editProduct.jsp");
        request.setAttribute("product", product);
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void editProduct(HttpServletRequest request, HttpServletResponse response) {
        ProductService productService = new ProductService();

        int productId = Integer.parseInt(request.getParameter("Id"));
        String productName = request.getParameter("productName");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        String categorize = request.getParameter("categorize");
        Product product= new Product(productId,productName,price,quantity,color,description,categorize);

        boolean check= productService.saveProduct(product);
        ArrayList<Product> productList = productService.selectAllProduct();

        if (check) {
            String message = "Edit successful";
            RequestDispatcher dispatcher = request.getRequestDispatcher("Product.jsp");
            request.setAttribute("productList", productList);
            request.setAttribute("message", message);
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            String message = "Edit not successful";
            RequestDispatcher dispatcher = request.getRequestDispatcher("Product.jsp");
            request.setAttribute("message", message);
            request.setAttribute("productList", productList);
            try {
                request.setAttribute("product", product);
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void showDeleteProduct(HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher dispatcher = request.getRequestDispatcher("deleteProduct.jsp");
        ProductService productService = new ProductService();
        int productId =Integer.parseInt(request.getParameter("Id"));
        Product product = productService.findById(productId);

        try {
            request.setAttribute("product", product);
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        ProductService productService = new ProductService();
        int productId = Integer.parseInt(request.getParameter("Id"));
        boolean check = productService.deleteProduct(productId);

        //ArrayList<Product> productList = productService.selectAllProduct();
        RequestDispatcher dispatcher;
        //request.setAttribute("productList", productList);
        if(check){
            try {

                String message = "Delete successful";
                dispatcher = request.getRequestDispatcher("Product.jsp");
                request.setAttribute("message",message);
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            String message = "Delete not successful";
            dispatcher = request.getRequestDispatcher("Product.jsp");
            request.setAttribute("message",message);
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void showAddProduct(HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher dispatcher = request.getRequestDispatcher("addProduct.jsp");
        try {
            dispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addProduct(HttpServletRequest request, HttpServletResponse response){
        ProductService productService = new ProductService();

        int productId = Integer.parseInt(request.getParameter("productId"));
        String productName = request.getParameter("productName");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String color = request.getParameter("color");
        String description = request.getParameter("description");
        String categorize = request.getParameter("categorize");
        Product product = new Product(productId, productName, price, quantity, color, description, categorize);

        boolean check = productService.addProduct(product);
        ArrayList<Product> productList = productService.selectAllProduct();

        if(check) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("Product.jsp");
            // request.setAttribute("productList", productList);
            try {
                dispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            String message = "Add not successful";
            RequestDispatcher dispatcher = request.getRequestDispatcher("Product.jsp");
            request.setAttribute("message", message);
            //request.setAttribute("productList", productList);
            try {
                dispatcher.forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
