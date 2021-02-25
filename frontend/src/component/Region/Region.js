import React from "react";
import { connect } from "react-redux";

const Region = ({ region }) => {
  return (
    <div className="city">
      <table>
        <thead>
          <tr>
            <th>Name</th>
            <th>Population</th>
          </tr>
        </thead>

        <tbody>
          {Object.keys(region).map((key, index) => (
            <tr key={index}>
              <td>{key}</td>
              <td>{region[key]}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

const mapStateToProps = (state) => ({
  region: state.region,
});

export default connect(mapStateToProps)(Region);
