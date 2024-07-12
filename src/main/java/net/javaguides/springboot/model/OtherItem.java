package net.javaguides.springboot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "other_items")
public class OtherItem {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "years_used", nullable = false)
    private int yearsUsed;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "image_url")
    private String imageUrl;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "signup_id", nullable = false)
    private Signup signup;
    
    public OtherItem(String brand, int yearsUsed, String description, String imageUrl,Signup signup) {
        this.brand = brand;
        this.yearsUsed = yearsUsed;
        this.description = description;
        this.imageUrl = imageUrl;
        this.signup = signup;
    }

    // Getters and setters
    // Constructor(s), if needed
}
