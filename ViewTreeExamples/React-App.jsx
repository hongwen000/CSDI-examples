import React, { useState } from 'react';

const ButtonTextViewExample = () => {
  const [text, setText] = useState('This is a TextView');

  const handleButtonClick = (buttonNumber) => {
    setText(`Button ${buttonNumber} clicked`);
  };

  return (
    <div style={styles.container}>
      {/* TextView 显示在两个按钮上方 */}
      <div style={styles.textView}>{text}</div>
      
      {/* 两个按钮并排显示 */}
      <div style={styles.buttonContainer}>
        <button 
          style={styles.button} 
          onClick={() => handleButtonClick(1)}
        >
          Button 1
        </button>
        <button 
          style={styles.button} 
          onClick={() => handleButtonClick(2)}
        >
          Button 2
        </button>
      </div>
    </div>
  );
};

const styles = {
  container: {
    display: 'flex',
    flexDirection: 'column',
    alignItems: 'center',
    padding: '20px',
  },
  textView: {
    marginBottom: '10px',
    width: '100%',
    textAlign: 'center',
    fontSize: '20px',
  },
  buttonContainer: {
    display: 'flex',
    justifyContent: 'space-between',
    width: '100%',
  },
  button: {
    width: '45%',
    height: '50px',
    backgroundColor: '#AFEEEE',
    border: 'none',
    cursor: 'pointer',
  },
};

export default ButtonTextViewExample;
