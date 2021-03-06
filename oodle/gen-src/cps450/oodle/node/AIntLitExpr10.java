/* This file was generated by SableCC (http://www.sablecc.org/). */

package cps450.oodle.node;

import cps450.oodle.analysis.*;

@SuppressWarnings("nls")
public final class AIntLitExpr10 extends PExpr10
{
    private TIntlit _intlit_;

    public AIntLitExpr10()
    {
        // Constructor
    }

    public AIntLitExpr10(
        @SuppressWarnings("hiding") TIntlit _intlit_)
    {
        // Constructor
        setIntlit(_intlit_);

    }

    @Override
    public Object clone()
    {
        return new AIntLitExpr10(
            cloneNode(this._intlit_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAIntLitExpr10(this);
    }

    public TIntlit getIntlit()
    {
        return this._intlit_;
    }

    public void setIntlit(TIntlit node)
    {
        if(this._intlit_ != null)
        {
            this._intlit_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._intlit_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._intlit_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._intlit_ == child)
        {
            this._intlit_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._intlit_ == oldChild)
        {
            setIntlit((TIntlit) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
