<script>
export default {
  name: 'MenuItem',
  functional: true,
  props: {
    icon:{},
    iconType:{
       type: String,
       default: ''
    },
    title: {
      type: String,
      default: ''
    }
  },
  render(h, context) {
    const { icon, title, iconType } = context.props
    const vnodes = []
    
    if (icon && iconType!='1') {
      vnodes.push(<svg-icon icon-class={icon.icon}/>)
    }
    if (icon && iconType=='1') {
      vnodes.push(<i class={icon.elementICon}/>)
    }

    if (title) {
      vnodes.push(<span slot='title'>{(title)}</span>)
    }
    return vnodes
  }
}
</script>
