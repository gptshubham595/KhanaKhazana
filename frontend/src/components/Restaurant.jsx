import React, { useEffect } from "react";
import Footer from "./restaurant_components/Footer";
import Hero from "./restaurant_components/Hero";
import Navbar from "./restaurant_components/Navbar";
import Newsletter from "./restaurant_components/Newsletter";
// import Portfolio from "./restaurant_components/Portfolio";
import Products from "./restaurant_components/Products";
import ScrollToTop from "./restaurant_components/ScrollToTop";
import Services from "./restaurant_components/Services";
// import Testimonials from "./restaurant_components/Testimonials";
import scrollreveal from "scrollreveal";
export default function Restaurant() {
  // useEffect(() => {
  //   const sr = scrollreveal({
  //     origin: "top",
  //     distance: "80px",
  //     duration: 2000,
  //     reset: false,
  //   });
  //   sr.reveal(
  //     `
  //       nav,
  //       #home,
  //       #services,
  //       #portfolio,
  //       #testimonials,
  //       #products,
  //       #newsletter,
  //       .footer
  //   `,
  //     {
  //       opacity: 0,
  //       interval: 200,
  //     }
  //   );
  // }, []);
  return (
    <>
      <ScrollToTop />
      {/* <Navbar /> */}
      <Hero />
      <Services />
      {/* <Portfolio /> */}
      {/* <Testimonials /> */}
      <Products />
      <Newsletter />
      <Footer />
    </>
  );
}
// export default Restaurant
