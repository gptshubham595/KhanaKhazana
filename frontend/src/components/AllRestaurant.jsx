import React, { useEffect } from "react";
import Footer from "./all_restaurant_components/Footer";
import Hero from "./all_restaurant_components/Hero";
import Navbar from "./all_restaurant_components/Navbar";
// import Portfolio from "./restaurant_components/Portfolio";
import Products from "./all_restaurant_components/Products";
import ScrollToTop from "./all_restaurant_components/ScrollToTop";
import Services from "./all_restaurant_components/Services";
// import Testimonials from "./restaurant_components/Testimonials";
import scrollreveal from "scrollreveal";
export default function AllRestaurant() {
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
      {/*<Services />*/}
      {/* <Portfolio /> */}
      {/* <Testimonials /> */}
      <Products />
      {/*<Newsletter />*/}
      <Footer classname="gap-3"/>
    </>
  );
}
// export default Restaurant
