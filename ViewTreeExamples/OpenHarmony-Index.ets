@Entry
@Component
struct ButtonTextViewExample {
  build() {
    Column({ space: 10 }) {
      // TextView 显示在两个按钮上方
      Text('This is a TextView')
        .width('100%')
        .textAlign(TextAlign.Center)
        .fontSize(20)

      // 两个按钮并排显示
      Row({ space: 10 }) {
        Button('Button 1')
          .width('45%')
          .height(50)
          .onClick(() => {
            console.log('Button 1 clicked');
          })

        Button('Button 2')
          .width('45%')
          .height(50)
          .onClick(() => {
            console.log('Button 2 clicked');
          })
      }
      .width('100%')
      .height(50)
    }
    .width('100%')
    .padding({ top: 20 })
  }
}

