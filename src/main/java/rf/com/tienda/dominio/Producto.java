package rf.com.tienda.dominio;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "producto")
public class Producto {
    
    @Id
    private String id_producto;

    @Column(name = "descripcion_corta", nullable = false)
    private String pro_descripcion;

    @Column(name = "explicacion")
    private String pro_desLarga;

    @Column(name = "precio", nullable = false, scale = 2)
    private double pro_precio;

    @Column(name = "stock")
    private int pro_stock;

    @Column(name = "fecha_reposicion")
    private LocalDate pro_fecRepos;

    @Column(name = "fecha_activacion")
    private LocalDate pro_fecActi;

    @Column(name = "fecha_desactivacion")
    private LocalDate pro_fecDesacti;

    @Column(name = "unidad_Venta",nullable = false)
    private String pro_uniVenta;

    @Column(name = "cantidad_unidades_ultimas", scale = 2)
    private double pro_cantXUniVenta;

    @Column(name = "unidad_ultima")
    private String pro_uniUltNivel;

    @Column(name = "pais", nullable = false)
    private int id_pais;

    @Column(name = "uso_recomendado")
    private String pro_usoRecomendado;

    @OneToOne  
    private Categoria id_categoria;

    @ManyToOne
    @JoinColumn(name="id_categoria")
    private PedidoCarrito pedido;

    @Column(name = "stock_reservado")
    private int pro_stkReservado;

    @Column(name = "stock_nivel_alto")
    private int pro_nStkAlto;

    @Column(name = "stock_nivel_bajo")
    private int pro_nStkBajo;

    @Column(name = "estado")
    private char pro_stat;
}
