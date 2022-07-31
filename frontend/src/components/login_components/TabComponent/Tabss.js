import React from "react";
import Paper from "@mui/material/Paper";
import Tab from "@mui/material/Tab";
import Tabs from '@mui/material/Tabs';

const Tabss = () => {
  const [value, setValue] = React.useState(2);
  
  return (
    <div
      style={{
        marginTop: "15px",
        // backgroundColor: "#b66c13",
        color: "#b66c13",
      }}
    >
      {/* <h2>How to Create Tabs in ReactJS?</h2> */}
      <Paper square>
        <Tabs className='bg-gray-300'
          value={value}
          // backgroundColor="yellow"
          textColor="primary"
          indicatorColor="primary"
          onChange={(event, newValue) => {
            setValue(newValue);
          }}
        >
          <Tab label="Customer" />
          <Tab label="Restaurant Manager" />
          {/* <Tab label="Disabled TAB!" disabled />
          <Tab label="Active Tab Three" /> */}
        </Tabs>
        {/* <h3>TAB NO: {value} clicked!</h3> */}
      </Paper>
    </div>
  );
};
  
export default Tabss;