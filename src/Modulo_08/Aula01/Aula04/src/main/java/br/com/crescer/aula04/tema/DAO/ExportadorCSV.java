package br.com.crescer.aula04.tema.DAO;

import br.com.crescer.aula04.tema.Model.Cidade;
import br.com.crescer.aula04.tema.Model.Cliente;
import br.com.crescer.aula04.tema.Model.Material;
import br.com.crescer.aula04.tema.Model.Pedido;
import br.com.crescer.aula04.tema.Model.Produto;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class ExportadorCSV {

    private static Class tipoEntidade;

    public static String exportar(Object entidade) {
        tipoEntidade = entidade.getClass();
        String retorno;
        switch (tipoEntidade.getName()) {
            case "Pedido":
                try {
                    exportarPedidos();
                    retorno = "SUCESSO";
                    break;
                } catch (IOException ex) {
                    retorno = ex.getMessage();
                    break;
                }
            case "Cidade":
                try {
                    exportarCidades();
                    retorno = "SUCESSO";
                    break;
                } catch (IOException ex) {
                    retorno = ex.getMessage();
                    break;
                }
            case "Cliente":
                try {
                    exportarClientes();
                    retorno = "SUCESSO";
                    break;
                } catch (IOException ex) {
                    retorno = ex.getMessage();
                    break;
                }
            case "Material":
                try {
                    exportarMateriais();
                    retorno = "SUCESSO";
                    break;
                } catch (IOException ex) {
                    retorno = ex.getMessage();
                    break;
                }
            case "Produto":
                try {
                    exportarProdutos();
                    retorno = "SUCESSO";
                    break;
                } catch (IOException ex) {
                    retorno = ex.getMessage();
                    break;
                }
            default:
                retorno = "Entidade inválida!";
        }
        return retorno;
    }

    private static void exportarPedidos() throws IOException {
        PedidoDAO repositorio = new PedidoDAO();
        List<Pedido> todos = repositorio.listAll();
        FileWriter writer = new FileWriter(String.format("export-pedidos-%s.csv", new Date().toString()));
        for (Pedido pedido : todos) {
            writer.append(Long.toString(pedido.getIdPedido()));
            writer.append(",");
            writer.append(Long.toString(pedido.getCliente().getIdCliente()));
            writer.append(",");
            writer.append(pedido.getDataPedido().toString());
            writer.append(",");
            writer.append(pedido.getDataEntrega().toString());
            writer.append(",");
            writer.append(pedido.getValorPedido().toString());
            writer.append(",");
            writer.append(pedido.getSituacao());
            writer.append("\n");
        }
        writer.close();
    }

    private static void exportarCidades() throws IOException {
        CidadeDAO repositorio = new CidadeDAO();
        List<Cidade> todas = repositorio.listAll();
        FileWriter writer = new FileWriter(String.format("export-cidades-%s.csv", new Date().toString()));
        for (Cidade cidade : todas){
            writer.append(Long.toString(cidade.getIdCidade()));
            writer.append(",");
            writer.append(cidade.getNome());
            writer.append(",");
            writer.append(cidade.getUF());
            writer.append("\n");
        }
        writer.close();
    }

    private static void exportarClientes() throws IOException {
        ClienteDAO repositorio = new ClienteDAO();
        List<Cliente> todos = repositorio.listAll();
        FileWriter writer = new FileWriter(String.format("export-clientes-%s.csv", new Date().toString()));
        for(Cliente cliente : todos){
            writer.append(Long.toString(cliente.getIdCliente()));
            writer.append(",");
            writer.append(cliente.getNome());
            writer.append(",");
            writer.append(cliente.getRazaoSocial());
            writer.append(",");
            writer.append(cliente.getEndereco());
            writer.append(",");
            writer.append(cliente.getBairro());
            writer.append(",");
            writer.append(Long.toString(cliente.getCidade().getIdCidade()));
            writer.append(",");
            writer.append(Long.toString(cliente.getCep()));
            writer.append(",");
            writer.append(cliente.getSituacao());
            writer.append(",");
        }
        writer.close();
    }

    private static void exportarMateriais() throws IOException {
        MaterialDAO repositorio = new MaterialDAO();
        List<Material> todos = repositorio.listAll();
        FileWriter writer = new FileWriter(String.format("export-materiais-%s.csv", new Date().toString()));
        for(Material material : todos){
            writer.append(Long.toString(material.getIdMaterial()));
            writer.append(",");
            writer.append(material.getDescricao());
            writer.append(",");
            writer.append(Double.toString(material.getPesoLiquido()));
            writer.append(",");
            writer.append(material.getPrecoCusto().toString());
            writer.append("\n");
        }
        writer.close();
    }

    private static void exportarProdutos() throws IOException {
        ProdutoDAO repositorio = new ProdutoDAO();
        List<Produto> todos = repositorio.listAll();
        FileWriter writer = new FileWriter(String.format("export-cidades-%s.csv", new Date().toString()));
        for (Produto produto: todos){
            writer.append(Long.toString(produto.getIdProduto()));
            writer.append(",");
            writer.append(produto.getNome());
            writer.append(",");
            writer.append(produto.getDataCadastro().toString());
            writer.append(",");
            writer.append(produto.getPrecoCusto().toString());
            writer.append(",");
            writer.append(produto.getPrecoVenda().toString());
            writer.append(",");
            writer.append(produto.getSitucacao());
            writer.append("\n");            
        }
    }

}
